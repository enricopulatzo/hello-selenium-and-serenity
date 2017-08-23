appNs = appNs || {};

(function ($, app) {
  app.homepage = app.homepage || {};
  app.homepage.fetch = function () {
    return $.getJSON(app.contextRoot + "api/v1/messages");
  };
})(jQuery, appNs);
