function addRed(){
  const divTag = document.querySelector("#result");
  divTag.classList.add("red");
}

function addBlue(){
  const divTag = document.querySelector("#result");
  divTag.classList.add("blue");
}

function addGreen(){
  const divTag = document.querySelector("#result");
  divTag.classList.add("green");
}

function removeRed(){
  const divTag = document.querySelector("#result");
  divTag.classList.remove("red");
}

function removeBlue(){
  const divTag = document.querySelector("#result");
  divTag.classList.remove("blue");
}

function removeGreen(){
  const divTag = document.querySelector("#result");
  divTag.classList.remove("green");
}

// ===========================================================

function f01(){
  //요소노드 만들기
  const x = document.createElement('h1');

  //텍스트노드 만들기
  const y = document.createTextNode("안녕ㅋㅋ");

  //요소노드 하위에 텍스트노드 추가
  x.appendChild(y);

  //직접 만든 노드를 화면에 부착
  const bodyTag = document.querySelector("body");
  bodyTag.appendChild(x);
}


function f02(){
  //요소노드 만들기
  const imgTag = document.createElement('img');

  //속성 셋팅
  imgTag.setAttribute("src" , "../resources/img/abc3.png");
  imgTag.setAttribute("alt" , "귀여운캐릭터사진");
  imgTag.setAttribute("width" , "100px");
  imgTag.setAttribute("height" , "100px");

  //화면에 요소노드 부착하기
  const target = document.querySelector("#target");
  target.appendChild(imgTag);
}

function f03(){
  const imgTag = document.querySelector("img");
  imgTag.remove();
}

