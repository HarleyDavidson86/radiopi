function changeRadiostation(stationId) {
    fetch('api/radiostation/play/' + stationId)
        .then(function (response) {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            // Update the UI to reflect the change
            getData();
        })
        .catch(function (err) {
            console.error('Error changing radio station:', err);
        });
}