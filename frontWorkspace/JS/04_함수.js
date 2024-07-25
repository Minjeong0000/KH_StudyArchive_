// 선언적 함수
function f01(x){
  return x+1;
}

//익명 함수
const f02 = function(x){
  return x+1;
}

//화살표 함수
// const f03 = (x) => {return x+1;}
const f03 = x => x+1;



// ================================================================

const printNum = function(x){
  console.log(x);
  console.log(arguments);
}

// printNum(123 , 200, 300);


// ================================================================


function getTen(){
  return printNum;
}

const result = getTen();
// console.log(result);

// result(777);

// ==============================================================

// function hello(){
//   console.log("안녕~~~!");
// }

// const hi = hello();


// const x = undefined;
// console.log( typeof x );

// ==========================================

// const calcResult = 3/2; // 1.5 == 일반적인 숫자 == Finite == 인피티니아님
// const calcResult = 3/0; // Infinity

// const isFiniteResult = isFinite(calcResult);
// console.log(isFiniteResult);

// const calcResult = 1 / 5;
// console.log( isNaN(calcResult) );




