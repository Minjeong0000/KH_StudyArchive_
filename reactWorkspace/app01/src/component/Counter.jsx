import { useState } from "react";

function Counter(){

  console.log("Counter 컴포넌트 render...");

  const [value , setValue] = useState(0);

  const f01 = function(){
    setValue(value+1);
    console.log("증가된 value : " + value );
  };

  return (
    <>
      <h1>카운터</h1>
      <h1 id="target">{value}</h1>
      <button onClick={f01}>플러스</button>
    </>
  );
}

export default Counter;