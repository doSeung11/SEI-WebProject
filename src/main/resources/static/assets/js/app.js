function add_theater() {
    let tr = document.createElement('tr');
    let td = document.createElement('td');
    let textarea = document.createElement('textarea');

    td.setAttribute('class', 'theaters');
    textarea.setAttribute('class', "input_theater");
    textarea.setAttribute('placeholder', "상영관 입력");

    td.appendChild(textarea);
    tr.appendChild(td);

    let tbody = document.getElementById("tbody");
    let last_tr = document.getElementById("last_tr");

    tbody.insertBefore(tr, last_tr);

}

function add_time() {
    let tr = document.createElement('tr');
    let td1 = document.createElement('td');
    let td2 = document.createElement('td');
    let td3 = document.createElement('td');
    let td4 = document.createElement('td');
    let textarea1 = document.createElement('textarea');
    let textarea2 = document.createElement('textarea');
    let textarea3 = document.createElement('textarea');

    tr.setAttribute('class', 'new_input');
    textarea1.setAttribute('class', 'input_time');
    textarea2.setAttribute('class', 'input_time');
    textarea3.setAttribute('class', 'input_time');
    textarea1.setAttribute('placeholder', "상영 날짜 입력");
    textarea2.setAttribute('placeholder', "시작 시간 입력");
    textarea3.setAttribute('placeholder', "종료 시간 입력");

    td1.appendChild(textarea1);
    td2.appendChild(textarea2);
    td3.appendChild(textarea3);
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);

    let tbody = document.getElementById("tbody");

    tbody.appendChild(tr);

}

