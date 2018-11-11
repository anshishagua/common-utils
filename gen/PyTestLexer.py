# Generated from /Users/lixiao/code/common-utils/src/main/resources/PyTest.g4 by ANTLR 4.7
# encoding: utf-8
from __future__ import print_function
from antlr4 import *
from io import StringIO
import sys


def serializedATN():
    with StringIO() as buf:
        buf.write(u"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2")
        buf.write(u"\5\36\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\6\2\r\n")
        buf.write(u"\2\r\2\16\2\16\3\3\3\3\3\4\6\4\24\n\4\r\4\16\4\25\3\5")
        buf.write(u"\6\5\31\n\5\r\5\16\5\32\3\5\3\5\2\2\6\3\2\5\3\7\4\t\5")
        buf.write(u"\3\2\5\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\37\2\5\3")
        buf.write(u"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\3\f\3\2\2\2\5\20\3\2\2")
        buf.write(u"\2\7\23\3\2\2\2\t\30\3\2\2\2\13\r\t\2\2\2\f\13\3\2\2")
        buf.write(u"\2\r\16\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\4\3\2\2")
        buf.write(u"\2\20\21\7-\2\2\21\6\3\2\2\2\22\24\t\3\2\2\23\22\3\2")
        buf.write(u"\2\2\24\25\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\b\3")
        buf.write(u"\2\2\2\27\31\t\4\2\2\30\27\3\2\2\2\31\32\3\2\2\2\32\30")
        buf.write(u"\3\2\2\2\32\33\3\2\2\2\33\34\3\2\2\2\34\35\b\5\2\2\35")
        buf.write(u"\n\3\2\2\2\6\2\16\25\32\3\b\2\2")
        return buf.getvalue()


class PyTestLexer(Lexer):

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    PLUS = 1
    INTEGER = 2
    WS = 3

    channelNames = [ u"DEFAULT_TOKEN_CHANNEL", u"HIDDEN" ]

    modeNames = [ u"DEFAULT_MODE" ]

    literalNames = [ u"<INVALID>",
            u"'+'" ]

    symbolicNames = [ u"<INVALID>",
            u"PLUS", u"INTEGER", u"WS" ]

    ruleNames = [ u"LETTER", u"PLUS", u"INTEGER", u"WS" ]

    grammarFileName = u"PyTest.g4"

    def __init__(self, input=None, output=sys.stdout):
        super(PyTestLexer, self).__init__(input, output=output)
        self.checkVersion("4.7")
        self._interp = LexerATNSimulator(self, self.atn, self.decisionsToDFA, PredictionContextCache())
        self._actions = None
        self._predicates = None

