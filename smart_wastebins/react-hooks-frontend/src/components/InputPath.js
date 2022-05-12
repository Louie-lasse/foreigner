import React from 'react';
import ReactDOM from 'react-dom';
import { useState } from "react";
import BinService from "../services/BinService";
import PathService from "../services/PathService";
import InputBin from "./InputBin";

const InputPath = ({onSubmit}) => {

    const lat = 57.688343;
    const lng = 11.979447;


    const sendBins = (n) => {
        PathService.getPath(lat,lng).then(
            response => {
                onSubmit(response.data.right)
            }
        ).catch(
            error => console.log(error)
        )
    }

    return (
        <div>
            <InputBin onSubmit={n => sendBins(n)}/>
        </div>
    )
}

export default InputPath