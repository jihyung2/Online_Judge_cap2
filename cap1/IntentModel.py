import tensorflow as tf
from tensorflow.keras.models import Model, load_model
from tensorflow.keras import preprocessing
import pandas as pd

# 의도 분류 모델 모듈
class IntentModel:
    def __init__(self, model_name, preprocess):
        abc = pd.read_excel('../cap1/traindata생성용.xlsx')
        abc.dropna(inplace=True)
        print(f"common_sense shape => {abc.shape}")
        abc_intent = set(list(abc['intent']))
        real_intent = sorted(list(abc_intent))
        intentModel = {}
        for i in range(len(abc_intent)):
            intentModel[i] = real_intent[i]
        # 의도 클래스 별 레이블

        self.labels = intentModel

        # 의도 분류 모델 불러오기
        self.model = load_model(model_name)

        # 챗봇 Preprocess 객체
        self.p = preprocess


    # 의도 클래스 예측
    def predict_class(self, query):
        # 형태소 분석
        pos = self.p.pos(query)

        # 문장내 키워드 추출(불용어 제거)
        keywords = self.p.get_keywords(pos, without_tag=True)
        sequences = [self.p.get_wordidx_sequence(keywords)]

        # 단어 시퀀스 벡터 크기
        from GlobalParams import MAX_SEQ_LEN

        # 패딩처리
        padded_seqs = preprocessing.sequence.pad_sequences(sequences, maxlen=MAX_SEQ_LEN, padding='post')

        predict = self.model.predict(padded_seqs)
        predict_class = tf.math.argmax(predict, axis=1)
        return predict_class.numpy()[0]