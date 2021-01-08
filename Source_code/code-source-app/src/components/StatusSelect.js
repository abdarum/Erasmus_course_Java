const getStatusSelectOptions = (initValue) => {
    const statusValues = [
        "active",
        "suspended",
        "inactive",
        "to veryfication"
    ]

    const statusValuesSelect = [];
    var statusSingleValueSelect = {};

    function setStatusSelect() {
        statusValues.forEach(function (entry) {
            if (initValue !== undefined) {
                if (initValue === entry) {
                    statusSingleValueSelect = { value: `${entry}`, label: 'datasets.status.values.' + `${entry}` };
                }
            } else {
                statusValuesSelect.push({ value: `${entry}`, label: 'datasets.status.values.' + `${entry}` });
            }
        })
    }

    setStatusSelect();

    return statusValuesSelect.length ? statusValuesSelect :statusSingleValueSelect;
};

const getStatusDatabaseValues = (initValue) => {
    return initValue.value;
}

export  {getStatusSelectOptions, getStatusDatabaseValues};
