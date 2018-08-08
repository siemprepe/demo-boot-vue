// initial state
// shape: [{ id, quantity }]
const state = {
  user: "",
}

// getters
const getters = {
  getUser: (state, getters, rootState) => {
    return state.user
  }
}

// actions
const actions = {
  setUser ({ state, commit }, user) {
    state.user = user
    commit('setUser', { user: user })
  }
}

// mutations
const mutations = {
    setUser (state, { user }) {
      state.user = user
    }
}

export default {
  namespaced: true,
  state,
  getters,
  actions,
  mutations
}
