'use strict';
const {
  Model
} = require('sequelize');
module.exports = (sequelize, DataTypes) => {
  class Extensions extends Model {
    /**
     * Helper method for defining associations.
     * This method is not a part of Sequelize lifecycle.
     * The `models/index` file will call this method automatically.
     */
    static associate(models) {
      // define association here
    }
  }
  Extensions.init({
    extension: DataTypes.STRING,
    type: DataTypes.STRING,
    is_checked: DataTypes.BOOLEAN
  }, {
    sequelize,
    modelName: 'Extensions',
  });
  return Extensions;
};