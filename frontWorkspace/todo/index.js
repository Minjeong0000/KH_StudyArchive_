const btnTodoInsert = document.querySelector("#btn-todo-insert");
const btnTodoSelect = document.querySelector("#btn-todo-select");
const inputTag = document.querySelector("input[name=todo]");

//로컬스토리지 초기셋팅
localStorage.setItem("todo" , JSON.stringify([]));

//TODO insert
btnTodoInsert.addEventListener("click" , function(){
  const todoListStr = localStorage.getItem("todo");
  const todoList = JSON.parse(todoListStr);
  todoList.push(inputTag.value);
  localStorage.setItem("todo" , JSON.stringify(todoList));
});

//TODO select
btnTodoSelect.addEventListener("click" , function(){
  const todoListStr = localStorage.getItem("todo");
  const todoList = JSON.parse(todoListStr);

  //todoList 를 화면에 보여주기
  const todoListArea = document.querySelector("#todo-list-area"); //TODO 붙일 영역

  //화면 지우기 (기존TODO)
  todoListArea.innerHTML = "";

  //TODO 만들고, todoListArea에 붙이기
  for(const x of todoList){
    const divTag = document.createElement("div");
    const todoText = document.createTextNode(x);
    divTag.appendChild(todoText);
    todoListArea.appendChild(divTag);
  }
  
});


