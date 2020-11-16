<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="博客标题" prop="blogTitle">
        <el-input
          v-model="queryParams.blogTitle"
          placeholder="请输入博客标题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="博客描述" prop="description">
        <el-input
          v-model="queryParams.description"
          placeholder="请输入博客描述"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="博客标记" prop="flag">
        <el-input
          v-model="queryParams.flag"
          placeholder="请输入博客标记"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否发布" prop="published">
        <el-input
          v-model="queryParams.published"
          placeholder="请输入是否发布"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:blog:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:blog:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:blog:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:blog:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="blogList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="博客" align="center" width="280">
        <template slot-scope="scope">
          <el-row>
            <el-col :span="10">
              <div class="demo-image__preview">
                <el-image
                  :src="scope.row.firstPicture"
                  :preview-src-list="[scope.row.firstPicture]">
                </el-image>
              </div>
            </el-col>
            <el-col :span="14">
              <p>标题：{{ scope.row.blogTitle }}</p>
              <p>是否可见：
                <el-switch
                  v-model="scope.row.published"
                  active-value="0"
                  inactive-value="1"
                  @change=""
                ></el-switch>
              </p>
            </el-col>
          </el-row>
        </template>
      </el-table-column>
      <el-table-column label="博客标记" align="center" prop="flag" :formatter="blogFlagFormat" />
      <el-table-column label="是否开启赞赏" align="center" prop="appreciateFunction" />
      <el-table-column label="是否开启评论功能" align="center" prop="commentFunction" />
      <el-table-column label="博客类型" align="center" prop="type.typeName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:blog:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:blog:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改博客对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="1500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules">
        <el-form-item label="博客标题" prop="blogTitle">
          <el-input v-model="form.blogTitle" placeholder="请输入博客标题" />
        </el-form-item>
        <el-form-item label="博客描述" prop="description">
          <el-input v-model="form.description" placeholder="请输入博客描述" />
        </el-form-item>
        <el-form-item label="博客内容" prop="blogContent">
          <mavon-editor v-model="form.blogContent" />
        </el-form-item>
        <el-form-item label="博客首图" prop="firstPicture">
          <el-input v-model="form.firstPicture" placeholder="请输入博客首图" />
        </el-form-item>
        <el-form-item label="博客标记" prop="flag">
          <el-select v-model="form.flag" placeholder="请输入博客标记">
            <el-option
              v-for="dict in blogFlagOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="是否开启赞赏" prop="appreciateFunction">
          <el-switch
            v-model="form.appreciateFunction"
            active-value="0"
            inactive-value="1">
          </el-switch>
        </el-form-item>
        <el-form-item label="是否开启评论功能" prop="commentFunction">
          <el-switch
            v-model="form.commentFunction"
            active-value="0"
            inactive-value="1">
          </el-switch>
        </el-form-item>
        <el-form-item label="是否发布" prop="published">
          <el-switch
            v-model="form.published"
            active-value="0"
            inactive-value="1">
          </el-switch>
        </el-form-item>
        <el-form-item label="博客类型" prop="typeId">
          <el-select v-model="form.typeId" placeholder="请选择类型">
            <el-option
              v-for="item in blogTypeOptions"
              :key="item.typeId"
              :label="item.typeName"
              :value="item.typeId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="博客标签" prop="typeId">
          <el-select v-model="form.tagIds" multiple placeholder="请选择标签">
            <el-option
              v-for="item in blogTagOptions"
              :key="item.tagId"
              :label="item.tagName"
              :value="item.tagId">
            </el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listBlog, getBlog, delBlog, addBlog, updateBlog, exportBlog } from "@/api/system/blog";
import { listAllType } from '@/api/system/type'
import { listAllTag } from '@/api/system/tag'
import Editor from '@/components/Editor/index'

export default {
  name: "List",
  components: { Editor },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 博客表格数据
      blogList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 博客类型
      blogTypeOptions: [],
      // 博客标签
      blogTagOptions: [],
      // 博客标记
      blogFlagOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: null,
        blogTitle: null,
        description: null,
        blogContent: null,
        firstPicture: null,
        flag: null,
        appreciateFunction: null,
        commentFunction: null,
        published: null,
        typeId: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        blogTitle: [
          { required: true, message: "博客标题不能为空", trigger: "blur" }
        ],
        description: [
          { required: true, message: "博客描述不能为空", trigger: "blur" }
        ],
        blogContent: [
          { required: true, message: "博客内容不能为空", trigger: "blur" }
        ],
        firstPicture: [
          { required: true, message: "博客首图不能为空", trigger: "blur" }
        ],
        flag: [
          { required: true, message: "博客标记不能为空", trigger: "blur" }
        ],
        appreciateFunction: [
          { required: true, message: "是否开启赞赏不能为空", trigger: "blur" }
        ],
        commentFunction: [
          { required: true, message: "是否开启评论功能不能为空", trigger: "blur" }
        ],
        published: [
          { required: true, message: "是否发布不能为空", trigger: "blur" }
        ],
        typeId: [
          { required: true, message: "类型不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList()
    this.getTypeList()
    this.getTagList()
    /** 加载商品库存状态 select */
    this.getDicts('sys_blog_flag').then(res => {
      this.blogFlagOptions = res.data
    })
  },
  methods: {
    /** 查询标签 */
    getTagList() {
      listAllTag().then(response => {
        console.log(response)
        this.blogTagOptions = response.data
      })
    },
    /** 查询博客类型 */
    getTypeList() {
      listAllType().then(response => {
        console.log(response)
        this.blogTypeOptions = response.data
      })
    },
    /** 查询博客列表 */
    getList() {
      this.loading = true;
      listBlog(this.queryParams).then(response => {
        console.log(response)
        this.blogList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 博客标记翻译
    blogFlagFormat(row) {
      return this.selectDictLabel(this.blogFlagOptions, row.flag)
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        blogId: null,
        userId: null,
        blogTitle: null,
        description: null,
        blogContent: '',
        firstPicture: null,
        flag: null,
        appreciateFunction: null,
        commentFunction: null,
        published: null,
        typeId: null,
        tagIds: []
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.blogId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加博客";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const blogId = row.blogId || this.ids
      getBlog(blogId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改博客";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.blogId != null) {
            updateBlog(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBlog(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const blogIds = row.blogId || this.ids;
      this.$confirm('是否确认删除博客编号为"' + blogIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delBlog(blogIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有博客数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportBlog(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
