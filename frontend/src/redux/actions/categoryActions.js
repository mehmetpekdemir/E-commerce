import * as actionTypes from "./actionTypes";
import * as apiCalls from "../../api/apiCalls";

export function getCategoriesSuccess(categories) {
  return {
    type: actionTypes.GET_CATEGORIES_SUCCESS,
    payload: categories,
  };
}

export function getCategories() {
  return function (dispatch) {
    apiCalls
      .getCategories()
      .then((response) => {
        dispatch(getCategoriesSuccess(response.data));
      })
      .catch((error) => {
        console.log(error);
      });
  };
}
