-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 21-06-2015 a las 00:18:42
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `azteca`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `agenda`
-- 

CREATE TABLE `agenda` (
  `fecha` date NOT NULL,
  `id_camion` int(11) NOT NULL,
  `destino` varchar(32) NOT NULL,
  `origen` varchar(32) NOT NULL,
  `regreso` date NOT NULL,
  `costo` double NOT NULL,
  `nombre_cliente` varchar(32) NOT NULL,
  `telefono` varchar(32) NOT NULL,
  PRIMARY KEY  (`fecha`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `agenda`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `camion`
-- 

CREATE TABLE `camion` (
  `id_camion` int(11) NOT NULL,
  `Descripcion_camion` varchar(32) NOT NULL,
  `perfil:camion` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `camion`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `cliente`
-- 

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `ape_patt` varchar(32) NOT NULL,
  `ape_mat` varchar(32) NOT NULL,
  `telefono` varchar(32) NOT NULL,
  `correro` varchar(32) NOT NULL,
  `fecha_alta` date NOT NULL,
  PRIMARY KEY  (`id_cliente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `cliente`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `destino`
-- 

CREATE TABLE `destino` (
  `id_destino` int(11) NOT NULL auto_increment,
  `estado_destino` varchar(32) NOT NULL,
  `municipio_destino` varchar(32) NOT NULL,
  PRIMARY KEY  (`id_destino`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `destino`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `facturado`
-- 

CREATE TABLE `facturado` (
  `id_facturado` int(11) NOT NULL,
  `valor` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `facturado`
-- 

INSERT INTO `facturado` VALUES (0, 'Si');
INSERT INTO `facturado` VALUES (0, 'No');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `folios`
-- 

CREATE TABLE `folios` (
  `id_folio` int(11) NOT NULL,
  `folio_del` int(11) NOT NULL,
  `folio_al` int(11) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  PRIMARY KEY  (`id_folio`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `folios`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `mantenimiento`
-- 

CREATE TABLE `mantenimiento` (
  `id_camion` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `refaccion` varchar(32) NOT NULL,
  `costo` double NOT NULL,
  `facturado` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `mantenimiento`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `origen`
-- 

CREATE TABLE `origen` (
  `id_origen` int(11) NOT NULL auto_increment,
  `estado_origen` varchar(32) NOT NULL,
  `municipio_origen` varchar(32) NOT NULL,
  PRIMARY KEY  (`id_origen`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `origen`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `perfil`
-- 

CREATE TABLE `perfil` (
  `id_perfil` int(11) NOT NULL auto_increment,
  `Descripcion` varchar(32) NOT NULL,
  PRIMARY KEY  (`id_perfil`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `perfil`
-- 

INSERT INTO `perfil` VALUES (1, 'Administrador');
INSERT INTO `perfil` VALUES (2, 'Empleado');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `perfil_camion`
-- 

CREATE TABLE `perfil_camion` (
  `id_perfilN` int(11) NOT NULL,
  `Descripcion` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `perfil_camion`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuario`
-- 

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL auto_increment,
  `nombre` varchar(32) NOT NULL,
  `ape_paterno` varchar(32) NOT NULL,
  `ap_materno` varchar(32) NOT NULL,
  `perfil` int(11) NOT NULL,
  `usuario` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY  (`id_usuario`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- Volcar la base de datos para la tabla `usuario`
-- 

INSERT INTO `usuario` VALUES (1, 'admin', 'admin', 'admin', 1, 'admin', '29d31eee44bfe265f122c85153a65916');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `vendedor`
-- 

CREATE TABLE `vendedor` (
  `id_vendedor` int(11) NOT NULL auto_increment,
  `nombre_vendedor` varchar(32) NOT NULL,
  `apep_vendedor` varchar(32) NOT NULL,
  `apem_vendedor` varchar(32) default NULL,
  `telefono_vendedor` varchar(32) NOT NULL,
  `ubicacion_vendedor` varchar(32) NOT NULL,
  `comision` double NOT NULL,
  PRIMARY KEY  (`id_vendedor`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `vendedor`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `venta_voleto`
-- 

CREATE TABLE `venta_voleto` (
  `fecha_salida` date NOT NULL,
  `id_camion` int(11) NOT NULL,
  `id_vendedor` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `precio` double NOT NULL,
  `voleto` int(11) NOT NULL,
  `asiento` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `venta_voleto`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `voleto`
-- 

CREATE TABLE `voleto` (
  `id_voleto` int(11) NOT NULL,
  `valor` varchar(32) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `voleto`
-- 

INSERT INTO `voleto` VALUES (0, 'Si');
INSERT INTO `voleto` VALUES (0, 'No');
