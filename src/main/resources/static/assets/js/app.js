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

//<tr><td class="theaters"><textarea class="input_theater" placeholder="상영관 입력"></textarea></td></tr>