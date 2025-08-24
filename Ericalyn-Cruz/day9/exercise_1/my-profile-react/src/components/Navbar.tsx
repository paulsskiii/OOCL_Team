import React from "react";
import { Container, Nav, Navbar } from "react-bootstrap";

const MyNavbar: React.FC = () => {
  return (
    <Navbar bg="dark" variant="dark" expand="lg">
      <Container>
        <Navbar.Brand href="#">My Website</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#">Home</Nav.Link>
            <Nav.Link href="#">Portfolio</Nav.Link>
            <Nav.Link href="#">Contact</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default MyNavbar;
