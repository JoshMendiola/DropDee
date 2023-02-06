import React, {useEffect, useState} from "react";
import {Container, List, ListItemButton, ListItemText, Paper} from "@mui/material";



export default function PopularBandsList()
{
    const paperStyle = {padding: "50px 20x", width: 700 , margin:"40px auto"}
    const bandStyle = {margin:"auto", textAlign:"center"}
    const [topBands, setTopBands] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/bands")
            .then(res => res.json())
            .then((result) => {setTopBands(result)})
        },[])


    return (
        <Container>
            <Paper elevation = {3} style = {paperStyle}>
                <h1 style={bandStyle}>Trending Bands</h1>
                <List sx={bandStyle} component="nav" aria-label="Trending Bands">
                    {topBands.map(band => (
                        <ListItemButton sx = {paperStyle} key = {band.bandID}>
                            <ListItemText primary={band.name}/>
                        </ListItemButton>
                    ))}
                </List>
            </Paper>
        </Container>
    )
}