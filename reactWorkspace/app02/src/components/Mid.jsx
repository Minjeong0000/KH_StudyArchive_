import styled from "styled-components";
import Aside from "./Aside";
import Main from "./Main";

const MidLayoutDiv = styled.div`
  width: 100%;
  height: 100%;
  display: grid;
  grid-template-rows: 1fr;
  grid-template-columns: 1fr 6fr 1fr;
  place-content: center center;
`;

export default function Mid(){
  return <>
    <MidLayoutDiv>
      <Aside str="참이슬후레쉬드세요" />
      <Main />
      <Aside str="갓만든맛카스" />
    </MidLayoutDiv>
  </>;
}

