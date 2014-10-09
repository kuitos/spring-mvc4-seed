/**
 * @author kui.liu
 * @since 2014/09/29 上午11:45
 */
"use strict";

var gulp = require('gulp'),
    clean = require('gulp-clean'),
    runSequence = require('run-sequence'),
    jshint = require('gulp-jshint'),
    concat = require('gulp-concat'),
    minifyCss = require('gulp-minify-css'),
    minifyHtml = require('gulp-minify-html'),
    uglify = require('gulp-uglify'),
    rev = require('gulp-rev'),
    replace = require('gulp-replace'),
    usemin = require('gulp-usemin');

gulp.task('clean', function () {
    return gulp.src('dist/*')
        .pipe(clean({force: true}));
});

gulp.task('copy-tpl', function () {
    return gulp.src('src/tpls/**/*.html')
        .pipe(minifyHtml({empty: true, quotes: true}))
        .pipe(gulp.dest('dist/tpls'));
});

gulp.task('copy-font', function () {
    return gulp.src('src/fonts/*')
        .pipe(gulp.dest('dist/fonts/'));
});

gulp.task('copy-image', function () {
    return gulp.src('src/images/**/*')
        .pipe(gulp.dest('dist/images'));
});

gulp.task('copy-ccmsPop-image', function () {
    return gulp.src('src/js/lib/ccms_pop/css/img/*')
        .pipe(gulp.dest('dist/css/img/'));
});

gulp.task('copy-jqueryui-image', function () {
    return gulp.src('src/js/lib/jquery-ui/development-bundle/themes/base/images/*')
        .pipe(gulp.dest('dist/css/images'));
});

gulp.task('usemin', function () {
    return gulp.src('src/index.html')
        .pipe(replace(/\/src\/(js|css)/g, '$1'))
        .pipe(usemin({
            css : [minifyCss({keepSpecialComments: 0}), rev()],
            html: [minifyHtml({empty: true, quotes: true})],
            js  : [uglify(), rev()]
        }))
        .pipe(replace(/(js\/|css\/)/g, "/dist/$1"))
        .pipe(replace(/\/src\//g, "/dist/"))
        .pipe(gulp.dest('dist/'));
});

gulp.task('build', function (cb) {
    runSequence('clean', ['copy-tpl', 'copy-font', 'copy-image', 'copy-ccmsPop-image', 'copy-jqueryui-image', 'usemin'], cb);
});
