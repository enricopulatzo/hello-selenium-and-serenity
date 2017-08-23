appNs = appNs || {};

(function ($, app) {
  $(document).ready(function () {
    app.contextRoot = document.body.dataset['contextRoot'];
    app.pageId = document.body.dataset['pageId'];
    app[app.pageId] && app[app.pageId].init && app[app.pageId].init();
  });
})(jQuery, appNs);
