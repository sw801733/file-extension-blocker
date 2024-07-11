// 서비스 인스턴스 생성
const fixExtensionService = require('../services/fixExtensionService');

class fixExtensionController {

    fixExtensionService = new fixExtensionService();

    getAllFixExtension = async (req, res, next) => {
        // 모든 고정 확장자 조회
        const extensions = await this.fixExtensionService.findAllEnabledExtensions();

        console.log("고정 확장자 조회");
        res.status(200).json({data : extensions});
    }

    enableFixExtension = async (req, res, next) => {
        // 고정 확장자 활성화
        const {extensionName, extensionType} = req.body;
        const extension = await this.fixExtensionService.addExtension(extensionName, extensionType);

        console.log("고정 확장자 활성화");
        res.status(200).json({data : extension});
    }

    disableFixExtension = async (req, res, next) => {
        // 고정 확장자 비활성화
        const {extensionName, extensionType} = req.body;
        const extension = await this.fixExtensionService.deleteExtension(extensionName, extensionType);

        console.log("고정 확장자 비활성화");
        res.status(200).json({data : extension});
    }
}

module.exports = fixExtensionController;