import request from '@/utils/request'

// 查询博客评论列表
export function listComment(query) {
  return request({
    url: '/system/comment/list',
    method: 'get',
    params: query
  })
}

// 查询博客评论详细
export function getComment(commentId) {
  return request({
    url: '/system/comment/' + commentId,
    method: 'get'
  })
}

// 新增博客评论
export function addComment(data) {
  return request({
    url: '/system/comment',
    method: 'post',
    data: data
  })
}

// 修改博客评论
export function updateComment(data) {
  return request({
    url: '/system/comment',
    method: 'put',
    data: data
  })
}

// 删除博客评论
export function delComment(commentId) {
  return request({
    url: '/system/comment/' + commentId,
    method: 'delete'
  })
}

// 导出博客评论
export function exportComment(query) {
  return request({
    url: '/system/comment/export',
    method: 'get',
    params: query
  })
}