const movie = document.querySelectorAll('.movie-button');
const movieNo = document.querySelector('.movie-list-num');
const theaterLocation= document.querySelectorAll('.theater-location');
const theaterPlace = document.querySelectorAll('.theater-place');
const reserveTimeWant = document.querySelectorAll('.reserve-time-button');
const inputTitle = document.querySelector('.title');
const inputSelectedMovie = document.querySelector('.movieNo');
const inputSelectedTheater = document.querySelector('.selectedTheater');
const inputRunningTime = document.querySelector('.runningTime')

function count(type)  {
  // 인원당 가격 결과를 표시할 element
  const resultAdultElement = document.getElementById('result-adult');
  const resultChildElement = document.getElementById('result-child');
  const resultPreferElement = document.getElementById('result-prefer');
  const costElement = document.getElementById('costResult');

  // 현재 화면에 표시된 값
  let numberAdult = resultAdultElement.innerText;
  let numberChild = resultChildElement.innerText;
  let numberPrefer = resultPreferElement.innerText;
  let cost = costElement.innerText;

  // 더하기/빼기
    //성인
  if(type == 'plusAdult') {
    numberAdult = parseInt(numberAdult) + 1;
    cost = parseInt(cost) + 12000;
  }else if(type === 'minusAdult')  {
    if(numberAdult>=1){
      numberAdult = parseInt(numberAdult) - 1;
      cost = parseInt(cost) - 12000;
    }
  }
  else if(type == 'plusChild') {//어린이
    numberChild = parseInt(numberChild) + 1;
    cost = parseInt(cost) + 10000;
  }else if(type == 'minusChild')  {
    if(numberChild>=1){
      numberChild = parseInt(numberChild) - 1;
      cost = parseInt(cost) - 10000;
    }
  }else if(type == 'plusPrefer') {//우대
    numberPrefer = parseInt(numberPrefer) + 1;
    cost = parseInt(cost) + 8000;
  }else if(type == 'minusPrefer')  {
    if(numberPrefer>=1){
      numberPrefer = parseInt(numberPrefer) - 1;
      cost = parseInt(cost) - 8000;
    }
  }


  // 결과 출력
  resultAdultElement.innerText = numberAdult;
  resultChildElement.innerText = numberChild;
  resultPreferElement.innerText = numberPrefer;
  costElement.innerText = cost;
}

//영화 선택시 배경색 등 바뀌도록
movie.forEach(list => {
    list.addEventListener('click', function() {
        const movieTitleWrapper = document.querySelectorAll('.movie-list-title-active');
        movieTitleWrapper.forEach(li => {
            li.classList.remove('movie-list-title-active');
        });
        list.classList.add('movie-list-title-active');


        console.log(list.innerText);
        console.log(list.innerText[list.innerText.length-4]+list.innerText[list.innerText.length-3]);

        if(list.innerText[list.innerText.length-4] != '*'){
           inputSelectedMovie.value = list.innerText[list.innerText.length-4]+list.innerText[list.innerText.length-3];
        }else{
            inputSelectedMovie.value = list.innerText[list.innerText.length-3];
        }
    });
});

//극장지역 선택시 배경색 등 바뀌도록
theaterLocation.forEach(list => {
    list.addEventListener('click', function() {
        const theaterLocationWrapper = document.querySelectorAll(
            '.theater-location-active'
        );
        theaterLocationWrapper.forEach(li => {
            li.classList.remove('theater-location-active');
        });
        list.classList.add('theater-location-active');
        console.log(list.innerHTML);
    });
});

//영화관 선택시 배경색 등 바뀌도록
theaterPlace.forEach(list => {
    list.addEventListener('click', function() {
        const theaterPlaceWrapper = document.querySelectorAll(
            '.theater-place-active'
        );
        theaterPlaceWrapper.forEach(li => {
            li.classList.remove('theater-place-active');
        });
        list.classList.add('theater-place-active');
        console.log(list.innerText);
        console.log(list.innerText[list.innerText.length-2]+list.innerText[list.innerText.length-1]);

        if(list.innerText[list.innerText.length-2] != '*'){
           inputSelectedTheater.value = list.innerText[list.innerText.length-2]+list.innerText[list.innerText.length-1];
        }else{
            inputSelectedTheater.value = list.innerText[list.innerText.length-1];
        }

    });
});

//시간 선택시 배경색 등 바뀌도록
reserveTimeWant.forEach(list => {
    list.addEventListener('click', function() {
        const reserveTimeActive = document.querySelectorAll('.reserve-time-active');
        reserveTimeActive.forEach(li => {
            li.classList.remove('reserve-time-active');
        });
        list.classList.add('reserve-time-active');
        console.log(list.innerHTML);
        inputRunningTime.value = list.innerHTML;
    });
});
