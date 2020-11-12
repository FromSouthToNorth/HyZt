import request from '@/utils/request'

// 查询博客列表
export function listBlog(query) {
  return request({
    url: '/system/blog/list',
    method: 'get',
    params: query
  })
}

// 查询博客详细
export function getBlog(blogId) {
  return request({
    url: '/system/blog/' + blogId,
    method: 'get'
  })
}

// 新增博客
export function addBlog(data) {
  return request({
    url: '/system/blog',
    method: 'post',
    data: data
  })
}

// 修改博客
export function updateBlog(data) {
  return request({
    url: '/system/blog',
    method: 'put',
    data: data
  })
}

// 删除博客
export function delBlog(blogId) {
  return request({
    url: '/system/blog/' + blogId,
    method: 'delete'
  })
}

// 导出博客
export function exportBlog(query) {
  return request({
    url: '/system/blog/export',
    method: 'get',
    params: query
  })
}