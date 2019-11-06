/**
 * tagsView 保存 TagView 需要的的所有状态，维护了两个数组
 * @type {{cachedViews: Array, visitedViews: Array}}
 */
const state = {
  visitedViews: [],
  cachedViews: []
}

/**
 * state 只能由提交 mutation 进行改变，actions 只能提交mutation
 * 每个 mutation 都有一个字符串的 事件类型 (type) 和 一个 回调函数 (handler)。
 * 这个回调函数就是我们实际进行状态更改的地方，并且它会接受 state 作为第一个参数：
 * @type {{}}
 */
const mutations = {
  /**
   * 添加一个访问过的页面
   * @param state
   * @param view
   * @returns {number}
   * @constructor
   */
  ADD_ViSITED_VIEW(state, view) {
    if (state.visitedViews.some(value => value.path === view.path)) {
      return state.visitedViews.push(
        Object.assign({}, view, {
          title: view.meta.title || 'no-name'
        })
      )
    }
  }

}

const actions = {

}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}

