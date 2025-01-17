import styled from "styled-components";
import Top from "./Top";
import Mid from "./Mid";
import Bot from "./Bot";

const MyDiv = styled.div`
  display:grid;
  width:100vw;
  height: 100vh;
  
  grid-template-rows: 2fr 7fr 1fr;
  grid-template-columns: 1fr;
`;

function LayoutDiv(){
  return (<>
    <MyDiv>
      <Top />
      <Mid />
      <Bot />
    </MyDiv>
  </>);
}

export default LayoutDiv;