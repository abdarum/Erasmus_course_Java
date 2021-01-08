const getStatusSelectOptions = (initArray) => {
    const statusValues = [
        "active",
        "suspended",
        "inactive",
        "to veryfication"
    ]

    const statusValuesSelect = [];

    function setStatusSelect() {
        statusValues.forEach(function (entry) {
            if (initArray !== undefined) {
                if (initArray.includes(entry)) {
                    statusValuesSelect.push({ value: `${entry}`, label: 'datasets.status.values.' + `${entry}` });
                }
            } else {
                statusValuesSelect.push({ value: `${entry}`, label: 'datasets.status.values.' + `${entry}` });
            }
        })
    }

    setStatusSelect();

    return (statusValuesSelect);
};

const getStatusDatabaseValues = (initArray) => {
    var returnValuesArray = []
    initArray.forEach(function (entry) {
        returnValuesArray.push(entry.value);
    });
    return returnValuesArray;
}
export  {getStatusSelectOptions, getStatusDatabaseValues};
