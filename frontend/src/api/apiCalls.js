import axios from "axios";

//const url = "http://localhost:8050/";

export const getCategories = () => {
  return axios.get("/api/category/get");
};

export const getProducts = () => {
  return axios.get("/api/product/get");
};
