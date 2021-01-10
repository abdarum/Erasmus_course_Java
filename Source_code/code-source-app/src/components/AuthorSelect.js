const getAuthorSelectOptions = (asyncList, initValue) => {
    console.log(asyncList);

    const authorValuesSelect = [];
    var authorSingleValueSelect = {};

    function setStatusSelect() {
        asyncList.forEach(function (entry) {
            if (initValue !== undefined) {
                if (initValue === entry.id) {
                    authorSingleValueSelect = { value: `${entry.id}`, label: `${entry.firstName}` + ' ' + `${entry.lastName}` };
                }
            } else {
                authorValuesSelect.push({ value: `${entry.id}`, label: `${entry.firstName}` + ' ' + `${entry.lastName}` });
            }
        })
    }

    setStatusSelect();

    return authorValuesSelect.length ? authorValuesSelect : authorSingleValueSelect;
};

const getAuthorDatabaseValues = (initValue) => {
    return initValue.value;
}

export { getAuthorSelectOptions, getAuthorDatabaseValues };
