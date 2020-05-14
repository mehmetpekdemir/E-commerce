import React, { Component } from "react";
import { Switch, Route } from "react-router-dom";
import Navi from "../../shared/navi/Navi";
import CategoryContainer from "../category/CategoryContainer";
import ProductContainer from "../product/ProductContainer";
import NotFound from "../../shared/notfound/NotFound";

export default class App extends Component {
  render() {
    return (
      <div>
        <Navi />
        <Switch>
          <Route path="/" exact></Route>
          <Route path="/category" component={CategoryContainer}></Route>
          <Route path="/product" component={ProductContainer}></Route>
          <Route component={NotFound}></Route>
        </Switch>
      </div>
    );
  }
}
