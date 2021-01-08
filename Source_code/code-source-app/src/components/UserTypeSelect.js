const getUserTypeSelectOptions = (initValue) => {
    const userTypeValues = [
        1,
        2,
        3
    ]

    const userTypeValuesSelect = [];
    var userTypeSingleValueSelect = {};

    function setUserTypeSelect() {
        userTypeValues.forEach(function (entry) {
            if (initValue !== undefined) {
                if (initValue === entry) {
                    userTypeSingleValueSelect = { value: `${entry}`, label: 'datasets.user_type.values.' + `${entry}` };
                }
            } else {
                userTypeValuesSelect.push({ value: `${entry}`, label: 'datasets.user_type.values.' + `${entry}` });
            }
        })
    }

    setUserTypeSelect();

    return userTypeValuesSelect.length ? userTypeValuesSelect : userTypeSingleValueSelect;
};

const getUserTypeDatabaseValues = (initValue) => {
    return initValue.value;
}
export { getUserTypeSelectOptions, getUserTypeDatabaseValues };
