import styled, { css } from 'styled-components';
import React, { Component }  from 'react';

const theme = {
    lightBlue: {
        default: "#116290",
        hover: "#124290"
    },
    lightGreen: {
        default: "#007868",
        hover: "#007640"

    }
};

const Button = styled.button`
  background-color: ${(props) => theme[props.theme].default};
  color: white;
  padding: 5px 15px;
  border-radius: 5px;
  outline: 0;
  text-transform: uppercase;
  margin: 10px 0px;
  cursor: pointer;
  box-shadow: 0px 2px 2px lightgray;
  transition: ease background-color 250ms;
  &:hover {
    background-color: ${(props) => theme[props.theme].hover};
  }
  &:disabled {
    cursor: default;
    opacity: 0.7;
  }
`;
Button.defaultProps = {
    theme: "blue"
};


export default Button;
