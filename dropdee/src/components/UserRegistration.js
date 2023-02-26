import React, {useState} from "react";
import {Container, Paper, TextField} from "@mui/material";
import Button from "@mui/material/Button";

export default function UserRegistration()
{
    const paperStyle = {padding: "50px 20x", width: 600 , margin:"20px auto"}
    const [userID, setUserID] = useState(null)
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState(null);
    const [phoneNumber, setPhoneNumber] = useState(null)
    const handleUserSubmit=(e) =>
    {
        e.preventDefault()
        const user = {userID, username, password, email, phoneNumber}
        console.log(user)
        fetch("http://localhost:8080/useraccount", {
            method: "POST",
            headers:{"content-type":"Application/json"},
            body: JSON.stringify(user)
        }).then(() => console.log("New User Registered"))
    }

    return (
        <Container>
            <Paper elevation = {3} style = {paperStyle}>
                <h1 style = {{color:"blue"}}>Register your band !</h1>
                <form noValidate autoComplete={"off"}>
                    <TextField id="usernameInput" label="Username" variant="outlined" fullWidth
                               value={username}
                               onChange={(e) => setUsername(e.target.value)}
                    />
                    <TextField id="passwordInput" label="Username" variant="outlined" fullWidth
                               value={password}
                               onChange={(e) => setPassword(e.target.value)}
                    />
                    <TextField id="emailInput" label="Email" variant="outlined" fullWidth
                               value={email}
                               onChange={(e) => setEmail(e.target.value)}
                    />
                    <TextField id="phoneNumberInput" label="Phonenumber" variant="outlined" fullWidth
                               value={phoneNumber}
                               onChange={(e) => setUsername(e.target.value)}
                    />
                    <Button variant="contained"
                            style = {{margin: "auto"}}
                            onClick = {handleUserSubmit}
                    >
                        Submit</Button>
                </form>
            </Paper>
        </Container>
    )
}