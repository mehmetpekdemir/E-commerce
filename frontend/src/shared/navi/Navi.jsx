import React, { useState } from "react";
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem,
  NavbarText,
} from "reactstrap";

const Example = (props) => {
  const [isOpen, setIsOpen] = useState(false);

  const toggle = () => setIsOpen(!isOpen);

  return (
    <div>
      <Navbar color="light" light expand="md">
        <NavbarBrand href="/">Online Shopping App</NavbarBrand>
        <NavbarToggler onClick={toggle} />
        <Collapse isOpen={isOpen} navbar>
          <Nav className="mr-auto" navbar>
            <NavItem>
              <NavLink href="/register/">Register</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/sign-in/">Sign in</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/category">Category</NavLink>
            </NavItem>
            <NavItem>
              <NavLink href="/product">Product</NavLink>
            </NavItem>
            <UncontrolledDropdown nav inNavbar>
              <DropdownToggle nav caret>
                Optional
              </DropdownToggle>
              <DropdownMenu right>
                <DropdownItem>Testing</DropdownItem>
                <DropdownItem divider />
                <DropdownItem>Empty</DropdownItem>
              </DropdownMenu>
            </UncontrolledDropdown>
          </Nav>
          <NavbarText>Your Cart is Empty</NavbarText>
        </Collapse>
      </Navbar>
    </div>
  );
};

export default Example;
