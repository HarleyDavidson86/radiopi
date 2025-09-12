const getData = () => {
    fetch('inforightbottom').then(function (response) {
        return response.text();
    }).then(function (html) {
        console.log(html)
        document.getElementById("info-right").innerHTML = html;
    }).catch(function (err) {
        console.warn('Something went wrong.', err);
    });
    fetch('infoleftbottom').then(function (response) {
            return response.text();
        }).then(function (html) {
            console.log(html)
            document.getElementById("info-left").innerHTML = html;
        }).catch(function (err) {
            console.warn('Something went wrong.', err);
        });
}
// Initial call to fetch data
getData();
// Set interval to fetch data every 10 seconds
window.setInterval(getData, 10000);