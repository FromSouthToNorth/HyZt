import request from '@/utils/request'

// 查询博客标签列表
export function listTag(query) {
  return request({
    url: '/system/tag/list',
    method: 'get',
    params: query
  })
}

// 查询博客类型列表全部信息
export function listAllTag() {
  return request({
    url: '/system/tag/alltag',
    method: 'get'
  })
}

// 查询博客标签详细
export function getTag(tagId) {
  return request({
    url: '/system/tag/' + tagId,
    method: 'get'
  })
}

// 新增博客标签
export function addTag(data) {
  return request({
    url: '/system/tag',
    method: 'post',
    data: data
  })
}

// 修改博客标签
export function updateTag(data) {
  return request({
    url: '/system/tag',
    method: 'put',
    data: data
  })
}

// 删除博客标签
export function delTag(tagId) {
  return request({
    url: '/system/tag/' + tagId,
    method: 'delete'
  })
}

// 导出博客标签
export function exportTag(query) {
  return request({
    url: '/system/tag/export',
    method: 'get',
    params: query
  })
}
