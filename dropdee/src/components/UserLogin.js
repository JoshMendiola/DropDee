import React, {useState} from "react";
import {Container, Paper, TextField} from "@mui/material";
import Button from "@mui/material/Button";

export default function UserLogin(props)
{
    const paperStyle = {padding: "50px 20x", width: 600 , margin:"20px auto"}
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLoginSubmit=(e) =>
    {
        e.preventDefault()
        fetch(`http://localhost:8080/user/login/${username}/${password}`)
            .then(res => res.json())
            .then(result => props.handleLogin(result.userID))
            .catch(error => console.log(error))
    }

    return (
        <Container>
            <Paper elevation = {3} style = {paperStyle}>
                <h1 style = {{color:"blue", textAlign:'center', alignSelf: 'center'}}>Login to DropDee !</h1>
                <form noValidate autoComplete={"off"}>
                    <TextField id="usernameInput" label="Username" variant="outlined" fullWidth
                               value={username}
                               onChange={(e) => setUsername(e.target.value)}
                    />
                    <TextField id="passwordInput" label="Password" variant="outlined" fullWidth
                               value={password}
                               onChange={(e) => setPassword(e.target.value)}
                    />
                    <Button variant="contained"
                            style = {{margin: "auto", textAlign:'center', justifyContent: 'center'}}
                            onClick = {handleLoginSubmit}
                    >
                        Login </Button>
                </form>
            </Paper>
        </Container>
    )
}