const getUserTypeSelectOptions = (initArray) => {
    const userTypeValues = [
        1,
        2,
        3
    ]

    const userTypeValuesSelect = [];

    function setUserTypeSelect() {
        userTypeValues.forEach(function (entry) {
            if (initArray !== undefined) {
                if (initArray.includes(entry)) {
                    userTypeValuesSelect.push({ value: `${entry}`, label: 'datasets.user_type.values.' + `${entry}` });
                }
            } else {
                userTypeValuesSelect.push({ value: `${entry}`, label: 'datasets.user_type.values.' + `${entry}` });
            }
        })
    }

    setUserTypeSelect();

    return (userTypeValuesSelect);
};

const getUserTypeDatabaseValues = (initArray) => {
    var returnValuesArray = []
    initArray.forEach(function (entry) {
        returnValuesArray.push(entry.value);
    });
    return returnValuesArray;
}
export  {getUserTypeSelectOptions, getUserTypeDatabaseValues};
