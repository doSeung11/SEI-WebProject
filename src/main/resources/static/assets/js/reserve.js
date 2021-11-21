const movieTitle = document.querySelectorAll('.movie-button');
const theaterLocation= document.querySelectorAll('.theater-location');
const theaterPlace = document.querySelectorAll('.theater-place');
const reserveTimeWant = document.querySelectorAll('.reserve-time-button');
const inputTitle = document.querySelector('.title');
const inputSelectedTheater = document.querySelector('.selectedTheater');
const inputRunningTime = document.querySelector('.runningTime')

//영화 선택시 배경색 등 바뀌도록
movieTitle.forEach(list => {
    list.addEventListener('click', function() {
        const movieTitleWrapper = document.querySelectorAll('.movie-list-title-active');
        movieTitleWrapper.forEach(li => {
            li.classList.remove('movie-list-title-active');
        });
        list.classList.add('movie-list-title-active');
        console.log(list.innerHTML);
        inputTitle.value = list.innerHTML;
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
        console.log(list.innerHTML);
        inputSelectedTheater.value = list.innerHTML;
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
