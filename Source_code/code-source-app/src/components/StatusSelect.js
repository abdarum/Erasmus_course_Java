const getStatusSelectOptions = (initValue) => {
    const statusValues = [
        "active",
        "suspended",
        "inactive",
        "to veryfication"
    ]

    const statusValuesSelect = [];

    function setStatusSelect() {
        statusValues.forEach(function (entry) {
            if (initValue !== undefined) {
                if (initValue === entry) {
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
