import { AppBar, Avatar, Box, Button, Container, IconButton, Toolbar, Typography } from "@mui/material";
import MenuIcon from '@mui/icons-material/Menu';

export const Test: React.FC<{}> = ({}) => {
  return (
    <>
      <Box sx={{ display:"flex" }}>
        <AppBar sx={{alignContent:"center"}}>
          <Toolbar >
            <IconButton
              size="large"
              edge="start"
              color="inherit"
              aria-label="menu"
              sx={{ mr: 2 }}
            >

            </IconButton>
            <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            <Avatar alt="Francis Dale Canon" src="\src\assets\product_12925_68348a339f0223.48585529.jpg" />
            </Typography>
            <p>Francis Dale Cañon</p>
            {/* <Button color="inherit">LOGOUT</Button> */}
          </Toolbar>
        </AppBar>
      </Box>
      <h1 style={{textAlign:"center", paddingLeft:"50px", maxWidth:"300px", margin:"5px"}}> Hi, I'm Francis Dale </h1>
      <h2 style={{paddingLeft:"70px", margin:"5px"}}> based in Philippines.</h2>
      <Container style={{display:"flex"}}>
        <div style={{padding:"20px", maxWidth:"300px", textAlign:"justify"}}> Graduated at Far Eastern University - Institute of Technology with Bachelor of Science in Computer Science with specialization in Software Engineering. </div>
      {/* <div> asdasdaw </div> */}
        {/* <div style={{ display:"flex" }}> asdas</div> */}
        </Container>
      
    </>
  );
};
