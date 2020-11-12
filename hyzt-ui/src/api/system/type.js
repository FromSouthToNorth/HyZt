import request from '@/utils/request'

// 查询博客类型联列表
export function listType(query) {
  return request({
    url: '/system/type/list',
    method: 'get',
    params: query
  })
}

// 查询博客类型联详细
export function getType(typeId) {
  return request({
    url: '/system/type/' + typeId,
    method: 'get'
  })
}

// 新增博客类型联
export function addType(data) {
  return request({
    url: '/system/type',
    method: 'post',
    data: data
  })
}

// 修改博客类型联
export function updateType(data) {
  return request({
    url: '/system/type',
    method: 'put',
    data: data
  })
}

// 删除博客类型联
export function delType(typeId) {
  return request({
    url: '/system/type/' + typeId,
    method: 'delete'
  })
}

// 导出博客类型联
export function exportType(query) {
  return request({
    url: '/system/type/export',
    method: 'get',
    params: query
  })
}