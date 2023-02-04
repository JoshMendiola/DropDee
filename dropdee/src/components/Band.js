import {Container, Paper, TextField} from "@mui/material";
import React, {useState} from "react";
import Button from "@mui/material/Button";
import uuid from "react-uuid";

export default function Band()
{
    const paperStyle = {padding: "50px 20x", width: 600 , margin:"20px auto"}
    const [name, setName] = useState('');
    const [genre, setGenre] = useState('');
    const [bandID, setBandID] = useState(uuid);
    const [balance, setBalance] = useState(0);

    const handleBandSubmit=(e) =>
    {
        e.preventDefault()
        const band = {name, genre}
        console.log(band)
        fetch("http://localhost:8080/band", {
                method: "POST",
                headers:{"content-type":"Application/json"},
                body: JSON.stringify(band)
            }).then(() => console.log("New Band Added"))

    }

    return (
        <Container>
            <Paper elevation = {3} style = {paperStyle}>
                <h1 style = {{color:"blue"}}>Register your band !</h1>
                <form noValidate autoComplete={"off"}>
                    <TextField id="outlined-basic" label="Band Name" variant="outlined" fullWidth
                               value={name}
                               onChange={(e) => setName(e.target.value)}
                    />
                    <TextField id="outlined-basic" label="Band Genre" variant="outlined" fullWidth
                               value={genre}
                               onChange={(e) => setGenre(e.target.value)}
                    />
                    <Button variant="contained"
                            style = {{margin: "auto"}}
                            onClick = {handleBandSubmit}
                    >
                        Submit</Button>
                </form>
            </Paper>
        </Container>
    )
}