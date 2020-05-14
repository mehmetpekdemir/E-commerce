import * as actionTypes from "./actionTypes";
import * as apiCalls from "../../api/apiCalls";

export function getProductsSuccess(categories) {
  return {
    type: actionTypes.GET_PRODUCTS_SUCCESS,
    payload: categories,
  };
}

export function getProducts() {
  return function (dispatch) {
    apiCalls
      .getProducts()
      .then((response) => {
        dispatch(getProductsSuccess(response.data));
      })
      .catch((error) => {
        console.log(error);
      });
  };
}
