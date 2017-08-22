
function lockBack() {
    window.location.hash = "locked";
    window.location.hash = "_locked";
    window.onhashchange = function () {
        {
            window.location.hash = "_";
        }
    };
}
jQuery(document).ready(function () {
    lockBack();
});
        