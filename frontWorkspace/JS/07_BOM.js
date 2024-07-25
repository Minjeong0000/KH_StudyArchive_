function openTest(){
  window.open("https://www.naver.com" , "abc" , "width=500, height=500, resizable=no, left=500, top=500");
}

function timeoutTest(){
  timer01 = setTimeout( () => {
    alert("hello~~~!");
  } , 3000 );
}

function intervalTest(){
  timer02 = setInterval( ()=>{
    console.log("2초 지남 ...");
  } , 2000);
}

function clearTimeoutTest(){
  clearTimeout( timer01 );
}

function clearIntervalTest(){
  clearInterval( timer02 );
}


function locationTest(){
  // location.href = "https://naver.com";
  location.reload();
}

function navigatorTest(){
  console.log(navigator);
}

function screenTest(){
  console.log(screen);
}