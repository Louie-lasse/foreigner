import styled from "styled-components";

const InputBin = ({onSubmit}) => {
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

    const handleSubmit=(e)=>{
        e.preventDefault();
        const nBins = e.target.numberOfBins.value;
        console.log("Number of bins: " + nBins);
        onSubmit(nBins);
      }

    return (
        <div className = "container">
           <form onSubmit={handleSubmit}>
                <input
                    onKeyPress={(event) => {
                        if (!/[1-9]/.test(event.key)) {
                        event.preventDefault();
                        }
                    }}
                    name = "numberOfBins"
                    placeholder="Number Of Bins"
                />
                <Button theme= "lightBlue"  >
                    Collect wastebins
                </Button>
            </form> 
        </div>
    )
}

export default InputBin