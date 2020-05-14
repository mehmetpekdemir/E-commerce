import { combineReducers } from "redux";
import categoryListReducer from "./categoryListReducer";
import productListReducer from "./productListReducer";

const rootReducer = combineReducers({
  categoryListReducer,
  productListReducer,
});

export default rootReducer;
