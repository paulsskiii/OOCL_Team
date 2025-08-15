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
        <div style={{padding:"20px", maxWidth:"300px", textAlign:"justify"}}> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus id malesuada ipsum. Praesent et nunc justo. Ut lacus diam, eleifend vel quam eget, sollicitudin dictum tellus. Nam eros tellus, fermentum eu bibendum eget, suscipit id turpis. Curabitur a sapien pellentesque, sodales arcu a, posuere nisi. Etiam sed tempor orci. In pulvinar gravida sollicitudin. Suspendisse vel placerat sem, id ultrices ipsum. Morbi in purus tempus, pretium felis quis, placerat mauris. Nulla ut enim malesuada, molestie nunc sed, porta ligula. Fusce sed molestie metus, vitae fringilla nisl. Nunc vestibulum ex nec urna convallis, a ullamcorper tellus bibendum. </div>
      {/* <div> asdasdaw </div> */}
        {/* <div style={{ display:"flex" }}> asdas</div> */}
        </Container>
      
    </>
  );
};
