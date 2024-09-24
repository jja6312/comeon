function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for (let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

const cvalue = getCookie("name");

if (cvalue) {
    let resData = `${cvalue}님 환영합니다 <br/> <a href="index.jsp">홈으로</a>`
    document.querySelector(".loginContainer").innerHTML = resData;
}