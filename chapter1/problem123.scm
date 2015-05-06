#!/usr/bin/gosh
;; -*- coding: utf-8 -*-

(define (smallest-divisor n) (find-divisor n 2))

(define (prime-next n)
  (if (= n 2) 3) (+ n 2))

(define (find-divisor n test-divisor)
  (cond ((> (square test-divisor) n) n)
	((divides? test-divisor n) test-divisor)
	(else (find-divisor n (prime-next test-divisor)))))

(define (divides? a b) (= (remainder b a) 0))

(define (prime? n)
  (= n (smallest-divisor n)))



