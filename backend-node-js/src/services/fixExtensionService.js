const Extensions = require("../models/extensions");

class fixExtensionService {
  addExtension = async (req, res, next) => {
    const extensionName = req.extensionName;
    const extensionType = req.extensionType;

    const extension = Extensions.findOne({
      where: {
        extension: extensionName,
        type: extensionType,
      },
    });

    const isChecked = extension.is_checked;

    if (!isChecked) {
      Extensions.update(
        { is_checked: true },
        {
          where: {
            extension: extensionName,
          },
        }
      );
    }

    return extension;
  };
}

module.exports = fixExtensionService;
